
package model;


public class PontoEspaco {
    private int x;
    private int y;
    private int z;
    
    public PontoEspaco(){
        this.setX(0);
        this.setY(0);
        this.setZ(0);
    }
    
    public PontoEspaco(int x, int y, int z){
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param z the z to set
     */
    public void setZ(int z) {
        this.z = z;
    }


    @Override
    public String toString() {
        return "(" + this.x + ";" + this.y + ";" + this.z + ")";
    }
}
