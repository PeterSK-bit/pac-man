package pacman.util;

public enum GhostState {
    CHASE,      // hunt player
    SCATTER,    // run to your corner and circle there
    FRIGHTENED, // scared fo player, running away
    RESPAWNING; // traveling to house for respawn
}
