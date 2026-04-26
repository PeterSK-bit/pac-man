package pacman.entity.ghost.pathfinding;

public class Graph {
    function buildGraph(grid) {
        const graph = {};   // { "x,y": [ {node: "x2,y2", weight: 1}, ... ] }

        const rows = grid.length;
        const cols = grid[0].length;
        const DIRS = [[0,1],[0,-1],[1,0],[-1,0]];

        function isWalkable(r, c) {
            return r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] !== '#';
        }

        function isJunction(r, c) {
            if (!isWalkable(r, c)) return false;
            // Križovatka = viac ako 2 voľné smery, alebo slepá ulička
        const openDirs = DIRS.filter(([dr, dc]) => isWalkable(r+dr, c+dc));
            return openDirs.length !== 2; // nie je rovná chodba
        }

        // Nájdi všetky uzly (start/end pozície + križovatky)
        const nodes = new Set();
        for (let r = 0; r < rows; r++)
            for (let c = 0; c < cols; c++)
                if (isJunction(r, c)) nodes.add(`${r},${c}`);

        // Pre každý uzol BFS/DFS po chodbe kým nenarazíš na ďalší uzol
        for (const nodeKey of nodes) {
            graph[nodeKey] = [];
        const [sr, sc] = nodeKey.split(',').map(Number);

            for (const [dr, dc] of DIRS) {
                let r = sr + dr, c = sc + dc, dist = 1;

                // Choď po chodbe kým nenarazíš na uzol alebo stenu
                while (isWalkable(r, c) && !nodes.has(`${r},${c}`)) {
                    r += dr; c += dc; dist++;
                }

                if (isWalkable(r, c) && nodes.has(`${r},${c}`)) {
                    graph[nodeKey].push({ node: `${r},${c}`, weight: dist });
                }
            }
        }

        return graph;
    }
}
