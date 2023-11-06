public class Entity {
    int key;
    int data;
    Entity nextEntity;

    public Entity(int key, int data){
        this.key = key;
        this.data = data;
        this.nextEntity = null;
    }

}
