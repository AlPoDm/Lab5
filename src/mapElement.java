public class mapElement {

    int hashKey;
    String myKey;
    String myValue;
    mapElement nextElement;

    public mapElement(String myKey, String myValue){
        this.myKey = myKey;
        this.hashKey = myKey.hashCode();
        this.myValue = myValue;
        this.nextElement = null;
    }
}
