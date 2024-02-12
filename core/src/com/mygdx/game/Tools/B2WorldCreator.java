package com.mygdx.game.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MarioBros;
import com.mygdx.game.Screens.PlayScreen;
import com.mygdx.game.Sprites.Other.Enemies.Enemy;
import com.mygdx.game.Sprites.Other.Enemies.Goomba;
import com.mygdx.game.Sprites.Other.Enemies.GopnikWithBat;


public class B2WorldCreator {
    private Array<Goomba> goombas;
    private Array<GopnikWithBat> turtles;
    //private Array<GopnikWithBat> gopnikWithBats; Turtle

    public B2WorldCreator(PlayScreen screen){
        World world = screen.getWorld();
        TiledMap map = screen.getMap();
        //create body and fixture variables
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        //ЗАМЕНИЛА 2 НА 1 ВСПОМНИ МЕНЯ
        //create ground bodies/fixtures
//        System.out.println(map.getLayers().get(1).getObjects().getByType(PolygonMapObject.class));

//        MapObject ss = map.getLayers().get("Objects").getObjects().get(0);
//        MapObjects ss = map.getLayers().
//        System.out.println(ss);

        for(MapObject object : map.getLayers().get(0).getObjects().getByType(PolygonMapObject.class)){

            System.out.println(map.getLayers().get(0).getObjects().getByType(PolygonMapObject.class));
            Polygon rect = ((PolygonMapObject) object).getPolygon();

//            bdef.type = BodyDef.BodyType.StaticBody;
//            PolygonShape polygonShape = new PolygonShape();
//
//            bdef.position.set((rect.getX() + rect.getBoundingRectangle().getWidth() / 2) / MarioBros.PPM, (rect.getY() + rect.getBoundingRectangle().getHeight() / 2) / MarioBros.PPM);
//            polygonShape.set(rect.getVertices());
//            body = world.createBody(bdef);
//
//            body.createFixture(polygonShape, 0.0f);
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getBoundingRectangle().getWidth() / 2) / MarioBros.PPM , (rect.getY() + rect.getBoundingRectangle().getHeight() / 2) / MarioBros.PPM - 0.2f);
            System.out.println((rect.getX() + rect.getBoundingRectangle().getWidth() / 2) / MarioBros.PPM +" " + (rect.getY() + rect.getBoundingRectangle().getHeight() / 2) / MarioBros.PPM);
            body = world.createBody(bdef);

            shape.setAsBox(rect.getBoundingRectangle().getWidth() / 2 / MarioBros.PPM, rect.getBoundingRectangle().getHeight() / 2 / MarioBros.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }




//        //create pipe bodies/fixtures
//        for(MapObject object : map.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
//            Rectangle rect = ((RectangleMapObject) object).getRectangle();
//
//            bdef.type = BodyDef.BodyType.StaticBody;
//            bdef.position.set((rect.getX() + rect.getWidth() / 2) / MarioBros.PPM, (rect.getY() + rect.getHeight() / 2) / MarioBros.PPM);
//
//            body = world.createBody(bdef);
//
//            shape.setAsBox(rect.getWidth() / 2 / MarioBros.PPM, rect.getHeight() / 2 / MarioBros.PPM);
//            fdef.shape = shape;
//            fdef.filter.categoryBits = MarioBros.OBJECT_BIT;
//            body.createFixture(fdef);
//        }
//
//        //create brick bodies/fixtures
//        for(MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
//            new Brick(screen, object);
//        }
//
//        //create coin bodies/fixtures
//        for(MapObject object : map.getLayers().get(4).getObjects().getByType(RectangleMapObject.class)){
//
//            new Coin(screen, object);
//        }

//        create all goombas
//        goombas = new Array<Goomba>();
//        for(MapObject object : map.getLayers().get(0).getObjects().getByType(RectangleMapObject.class)){
//            Rectangle rect = ((RectangleMapObject) object).getRectangle();
//            goombas.add(new Goomba(screen, rect.getX() / MarioBros.PPM, rect.getY() / MarioBros.PPM));
//        }

        goombas = new Array<Goomba>();
        for(MapObject object : map.getLayers().get(0).getObjects().getByType(PolygonMapObject.class)){
            Polygon rect = ((PolygonMapObject) object).getPolygon();
            goombas.add(new Goomba(screen, rect.getX() / MarioBros.PPM, rect.getY() / MarioBros.PPM));
        }

        /*turtles = new Array<Turtle>();
        for(MapObject object : map.getLayers().get(7).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();
            turtles.add(new Turtle(screen, rect.getX() / MarioBros.PPM, rect.getY() / MarioBros.PPM));
        }*/
        turtles = new Array<GopnikWithBat>();
        for(MapObject object : map.getLayers().get(0).getObjects().getByType(PolygonMapObject.class)){
            Polygon rect = ((PolygonMapObject) object).getPolygon();
            turtles.add(new GopnikWithBat(screen, rect.getX() / MarioBros.PPM, rect.getY() / MarioBros.PPM));
        }
    }

    public Array<Goomba> getGoombas() {
        return goombas;
    }
    public Array<Enemy> getEnemies(){
        Array<Enemy> enemies = new Array<Enemy>();
        enemies.addAll(goombas);
        enemies.addAll(turtles);
        return enemies;
    }
}