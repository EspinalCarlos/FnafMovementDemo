
package fnafstructure;

public abstract class Animatronico {
    protected int aiLevel;
    protected String nombre;

    public Animatronico(int aiLevel) {
        this.aiLevel = aiLevel;
    }

    public Animatronico(int aiLevel, String nombre) {
        this.aiLevel = aiLevel;
        this.nombre = nombre;
    }
    
    
    public int getAiLevel() {
        return aiLevel;
    }

    public void setAiLevel(int aiLevel) {
        this.aiLevel = aiLevel;
    }
    
    abstract void movementChance();
    
}
