package com.mygdx.game.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import java.awt.Rectangle;

public class Coin extends InteractiveTileObject {
    public Coin(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);


    }
}
