package pacman.entity;

import pacman.util.Direction;
import pacman.util.Position;
import fri.shapesge.Image;

public abstract class Entity {
    private Position position;
    private int speed;
    private Direction direction;
    private Image sprite;

    public Entity(Position position, int speed, Direction direction) {
        this.position = position;
        this.speed = speed;
        this.direction = direction;
    }

    public Entity(int x, int y, int speed, Direction direction) {
        this(new Position(x, y), speed, direction);
    }
}
