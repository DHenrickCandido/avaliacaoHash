public class HashTableDivision {
    Entity[] buckets;
    int size;
    int colisions; 
    int entries;
    double loadFactor = 0.75;

    public HashTableDivision(int size) {
        this.size = size;
        buckets = new Entity[size];
    }   

    public int hash(int key) {
        int index = key % size;

        return index;
    }

    public void rehash() {
        size = size * 2;
        HashTableDivision newHashTable = new HashTableDivision(size);
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
        if(entries/(double)size >= loadFactor){
            rehash();
        }
        int index = hash(key);
        if (buckets[index] != null) {
            Entity bucket = buckets[index];
            boolean found = false;
            while(!found) {
                if (bucket.nextEntity == null) {
                    found = true;
                    bucket.nextEntity = new Entity(key, value);              
                } else {
                    bucket = bucket.nextEntity;
                }

            }
            
            colisions++;
        }
        else {
            buckets[index] = new Entity(key, value);
        }
        entries++;
    }

    public int get(int key) {
        int index = hash(key);
        if (buckets[index] != null) {
            if (buckets[index].nextEntity == null) {
                return buckets[index].data;
            }
            else {
                Entity bucket = buckets[index];
                boolean found = false;
                while(!found) {
                    if (bucket.nextEntity == null) {
                        found = true;
                        return bucket.data;           
                    } else {
                        bucket = bucket.nextEntity;
                    }
                }
                return bucket.data;
            }
        } else {
            return -1;
        }

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