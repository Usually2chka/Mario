package com.mygdx.game.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.World;

import java.awt.Rectangle;

public class Brick extends InteractiveTileObject{
    public Brick(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
    }
}
