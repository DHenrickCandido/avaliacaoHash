public class HashTableFolding {
    Entity[] buckets;
    int size;
    int colisions; 
    int entries;
    double loadFactor = 0.75;

    public HashTableFolding(int size) {
        this.size = size;
        buckets = new Entity[size];
    }   

    public int hash(int key) {
        int sum = 0;
        while(key > 0) {
            int digit = key % 10;
            sum += digit;

            key = key / 10;
        }
        

        return sum % size;
    }

    public void rehash() {
        size = size * 2;
        HashTableFolding newHashTable = new HashTableFolding(size);
        for(int i = 0; i < size/2; i++){
            if(buckets[i] != null) {
                newHashTable.insert(buckets[i].key,buckets[i].data);
            }                
        }
        entries = 0;
        colisions = 0;
        buckets = newHashTable.buckets;
    }

    public void insert(int key, int value) {
        if (entries / (double) size >= loadFactor) {
            rehash();
        }
        int index = hash(key);
        Entity current = buckets[index];
    
        if (current != null) {
            while (current.nextEntity != null) {
                current = current.nextEntity;
            }
            current.nextEntity = new Entity(key, value);
            colisions++;
        } else {
            buckets[index] = new Entity(key, value);
        }
        entries++;
    }
    

    public int get(int key) {
        int index = hash(key);
        Entity bucket = buckets[index];
        while (bucket != null) {
            if (bucket.key == key) {
                return bucket.data;
            }
            bucket = bucket.nextEntity;
        }
        return -1; // Chave não encontrada
    }
    

    public int getId(int key) {
        int index = hash(key);
        if (buckets[index] != null) {
            if (buckets[index].nextEntity == null) {
                return buckets[index].key;
            }
            else {
                Entity bucket = buckets[index];
                boolean found = false;
                while(!found) {
                    if (bucket.nextEntity == null) {
                        found = true;
                        return bucket.key;           
                    } else {
                        bucket = bucket.nextEntity;
                    }
                }
                return bucket.key;
            }
        } else {
            return -1;
        }
    }

    public String toString() {
        String ret = "";
        for (int i = 0; i < size; i++){
            if (buckets[i] != null) {
                if (buckets[i].nextEntity == null)
                    ret += buckets[i].data + "\n";
                else {
                    Entity bucket = buckets[i];
                    boolean foundLast = false;
                    while(!foundLast) {
                        if (bucket.nextEntity == null) {
                            ret += bucket.data + "\n";
                            foundLast = true;
                        } else {
                            ret += bucket.data + " ";
                            bucket = bucket.nextEntity;
                        }

                    }
                }
            } else {
                ret += "null \n";
            }

        }
        return ret;
    }

}