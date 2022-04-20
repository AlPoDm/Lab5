public class myMap {

    private int hashKey;
    private final mapElement[] myMainMap;
    private boolean f;
    private mapElement nextElem;
    private final int n;

    public myMap(int n){
        this.n = n;
        this.myMainMap = new mapElement[n];
    }

    public void put (String myKey, String myValue) {
        f = false;
        mapElement newEl = new mapElement(myKey,myValue);
        if (myMainMap[Math.abs(newEl.hashKey % n)] == null) {
            myMainMap[Math.abs(newEl.hashKey % n)] = newEl;
        } else {
            nextElem = myMainMap[Math.abs(newEl.hashKey % n)];
            do {
                if (nextElem.hashKey == newEl.hashKey){
                    if (nextElem.myKey.equals(newEl.myKey)){
                        nextElem.myValue = newEl.myValue;
                        f = true;
                    } else {
                        nextElem = nextElem.nextElement;
                    }
                } else {
                    nextElem = nextElem.nextElement;
                }
            } while ((nextElem != null) && (!f));
            if (!f){
                nextElem = myMainMap[Math.abs(newEl.hashKey % n)];
                while (nextElem.nextElement != null){
                    nextElem = nextElem.nextElement;
                }
                nextElem.nextElement = newEl;
            }
        }
    }

    public String get(String myKey) {
        f = find(myKey);
        if (f){
            return nextElem.myValue;
        } else {
            return "Элемент с заданным ключом не найден";
        }
    }

    public String remove(String myKey) {
        f = find(myKey);
        if (!f){
            return ("Элемент с заданным ключом не найден");
        } else {
            mapElement nMap = myMainMap[Math.abs(hashKey % n)];
            if (!nMap.equals(nextElem)) {
                while (!nMap.nextElement.equals(nextElem)) {
                    nMap = nMap.nextElement;
                }
                nMap.nextElement = nextElem.nextElement;
            } else {
                if (myMainMap[Math.abs(hashKey % n)].nextElement == null){
                    myMainMap[Math.abs(hashKey % n)] = null;
                }else{
                    myMainMap[Math.abs(hashKey % n)] = myMainMap[Math.abs(hashKey % n)].nextElement;
                }
            }
            return ("Элемент с ключом \"" + myKey + "\" удалён");
        }
    }

    private boolean find(String myKey){
        hashKey = myKey.hashCode();
        if (myMainMap[Math.abs(hashKey % n)] != null){
            nextElem = myMainMap[Math.abs(hashKey % n)];
            do {
                if (nextElem.hashKey == hashKey){
                    if (nextElem.myKey.equals(myKey)){
                        return true;
                    }
                }
                nextElem = nextElem.nextElement;
            } while (nextElem != null);
        }
        return false;
    }
}
