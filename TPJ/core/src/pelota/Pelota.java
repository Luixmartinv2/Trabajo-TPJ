package pelota;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.TimerTask;

/**
 * Created by luixmartinv2 on 25/5/18.
 */

public class Pelota {
    Texture img; // variable que representa la img de la pelota que es de tipo textura
    int x, y, z, marcador, M;

    public Pelota() {
        img = new Texture("pelota.png");
        x = 50;
        y = 50;
        z = 50;
        marcador=0;//sera el marcador
        M=1;//es para marcar los aumentos de velocidad
    }

    public void draw(SpriteBatch spriteBatch) {
        /*
        Hacemos uso del acelerómetro, dependiendo de la posición que nos marque este, iremos modificando la x e y
        lo que hara que al principio la pelota caiga hacia abajo independientemente de como tengamos el movil.
         */



        if(Gdx.input.getAccelerometerY()<0){
            x +=(Gdx.input.getAccelerometerY()*M);
        }else if(Gdx.input.getAccelerometerY()>0){
            x +=Gdx.input.getAccelerometerY()*M;
        }

        if(Gdx.input.getAccelerometerX()<0){

            y-=Gdx.input.getAccelerometerX()*M;

        }else if(Gdx.input.getAccelerometerX()>0){
            y-= (Gdx.input.getAccelerometerX()*M);
        }


        spriteBatch.draw(img, x, y, 100, 100);

        final int FPS = 40;
        //provisional -->
        TimerTask tas = new timerPelota();
        //tas.scheduleAtFixedRate(timerPelota, 0, 1000/FPS);
        while (marcador<10000)
            try {
                //aqui se asignan puntos,
                if(marcador==10000){
                    //win
                }else {
                    tas.wait(60000);
                    M++;//aqui aumentamos la velocidad

                    marcador++;}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }



    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
class timerPelota extends TimerTask {

    Pelota myBall;

    public void run() {
        //calculate the new position of myBall

    }
}


