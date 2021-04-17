import java.util.LinkedList;

public class HashTable<K, V> {
    private K key;
    private V value;
    private LinkedList<StudentEntry>[] hashTable;
    private int size;
    private int capacityIncrement;
    private int initialCapacity;

    public HashTable(int capacity) {
        initialCapacity = capacity;
        hashTable = new LinkedList[capacity];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<>();
        }
        size = 0;
        capacityIncrement = 0;
    }

    // If the key is an int data type we simply use that as our hash code
    public int intHashCode(int key) {
        return key;
    }

    // If the key is an String data type we apply the polynomial hash code method
    public int polynomialHashCode(String key) {
        int hashCode = 0;
        int polynomialHashConstant = 41;
        for (int i = 0; i < key.length(); i++) {
            hashCode += key.charAt(i) * Math.pow(polynomialHashConstant, key.length() - (i + 1));
        }

        return hashCode;
    }

    // For the compression function we use the division method
    public int compressionFunction(int hashCode) {
        return hashCode % hashTable.length;
    }

    // I have three functions for creating keys, each function generates a different type of key
    public String createKey(StudentEntry student) {
        String key;
        if (student.lastName.length() <= 3) {
            key = (student.birthYear % 100) + student.lastName.toLowerCase();
        } else {
            key = (student.birthYear % 100) + student.lastName.substring(0, 3).toLowerCase();
        }

        return key;
    }

    public int createKey2(StudentEntry student) {
        return student.birthYear + student.lastName.length() * student.firstName.length();
    }

    public String createKey3(StudentEntry student) {
        return student.firstName.substring(0, 1).toLowerCase() + student.lastName.substring(0, 1).toLowerCase() +
                Integer.parseInt(Integer.toString(student.birthYear).substring(0, 1)) + (student.birthYear % 10) + student.firstName.length();
    }

    public void addEntry(StudentEntry student, int keyType, int hashType) {
        // keyType == 1 means call the createKey() method, == 2 means createKey2() and so on.
        // hashType == 1 means call the polynomialHashCode() method, == 2 means call the direct intHashCode() method
        // Before adding the entry we check if the key is already present in the hash table
        for (LinkedList<StudentEntry> studentEntries : hashTable) {
            for (StudentEntry studentEntry : studentEntries) {
                if (keyType == 1) {
                    if (createKey(student).equals(createKey(studentEntry))) {
                        System.out.println("[FAILED] Sorry, a student entry with that key already exists.");
                        return;
                    }
                } else if (keyType == 2) {
                    if (createKey2(student) == createKey2(studentEntry)) {
                        System.out.println("[FAILED] Sorry, a student entry with that key already exists.");
                        return;
                    }
                } else if (keyType == 3) {
                    if (createKey3(student).equals(createKey3(studentEntry))) {
                        System.out.println("[FAILED] Sorry, a student entry with that key already exists.");
                        return;
                    }
                } else {
                    System.out.println("[FAILED] Invalid keyType requested.");
                }
            }
        }

        // If the key is not available, then we proceed to add it to the hash table
        int hashTableBucketIndex;

        if (keyType == 1 && hashType == 1) {
            hashTableBucketIndex = compressionFunction(polynomialHashCode(createKey(student)));
        } else if (keyType == 2 && hashType == 1) {
            hashTableBucketIndex = compressionFunction(polynomialHashCode(String.valueOf(createKey2(student))));
        } else if (keyType == 2 && hashType == 2) {
            hashTableBucketIndex = compressionFunction(intHashCode(createKey2(student)));
        } else if (keyType == 3 && hashType == 1) {
            hashTableBucketIndex = compressionFunction(polynomialHashCode(createKey3(student)));
        } else {
            System.out.println("[FAILED] Sorry, the keyType you provided cannot be used for the hash function you requested for.");
            return;
        }

        hashTable[hashTableBucketIndex].add(student);
        size++;

        // Checking to make sure the load factor has not exceeded the allowed percentage (90%)
        double loadFactor = (1.0 * size) / hashTable.length;

        if (loadFactor > 0.9) {
            System.out.println("[INFO] Rehashing the whole table because the load factor has increased 0.90.");
            rehash(keyType, hashType);
        }
    }

    public StudentEntry removeEntry(K key, int keyType, int hashType) {
        // Using the key to get the bucket index
        int hashTableBucketIndex;

        if (hashType == 1) {
            hashTableBucketIndex = compressionFunction(polynomialHashCode(String.valueOf(key)));
        } else if (hashType == 2) {
            hashTableBucketIndex = compressionFunction(intHashCode(Integer.parseInt(String.valueOf(key))));
        } else {
            System.out.println("[FAILED] Sorry, the hash function you requested for is not a valid function.");
            return null;
        }

        // Now based on the keyType the user requested, we find the entry and remove it if found
        for (int i = 0; i < hashTable[hashTableBucketIndex].size(); i++) {
            StudentEntry temp = hashTable[hashTableBucketIndex].get(i);
            if (keyType == 1) {
                if (createKey(temp).equals(key)) {
                    hashTable[hashTableBucketIndex].remove(i);
                    size--;
                    System.out.println("[SUCCESS] Student entry associated to key: " + key + " has been successfully removed.");
                    return temp;
                }
            } else if (keyType == 2) {
                if (createKey2(temp) == Integer.parseInt(String.valueOf(key))) {
                    hashTable[hashTableBucketIndex].remove(i);
                    size--;
                    System.out.println("[SUCCESS] Student entry associated to key: " + key + " has been successfully removed.");
                    return temp;
                }
            } else if (keyType == 3) {
                if (createKey3(temp).equals(key)) {
                    hashTable[hashTableBucketIndex].remove(i);
                    size--;
                    System.out.println("[SUCCESS] Student entry associated to key: " + key + " has been successfully removed.");
                    return temp;
                }
            } else {
                System.out.println("[FAILED] Sorry, the keyType you provided is not correct.");
                return null;
            }
        }

        // If nothing found we print an appropriate statement
        System.out.println("[FAILED] Sorry, we could not find any student data associated to this key: " + key + ".");
        return null;
    }

    public StudentEntry getEntry(K key, int keyType, int hashType) {
        // We use the key to find the bucket index
        int hashTableBucketIndex;

        if (hashType == 1) {
            hashTableBucketIndex = compressionFunction(polynomialHashCode(String.valueOf(key)));
        } else if (hashType == 2) {
            hashTableBucketIndex = compressionFunction(intHashCode(Integer.parseInt(String.valueOf(key))));
        } else {
            System.out.println("[FAILED] Sorry, the hash function you requested for is not a valid function.");
            return null;
        }

        // Now we try looking for the key in the bucket index that was calculated above
        for (int i = 0; i < hashTable[hashTableBucketIndex].size(); i++) {
            StudentEntry temp = hashTable[hashTableBucketIndex].get(i);
            if (keyType == 1) {
                if (createKey(temp).equals(key)) {
                    return temp;
                }
            } else if (keyType == 2) {
                if (createKey2(temp) == Integer.parseInt(String.valueOf(key))) {
                    return temp;
                }
            } else if (keyType == 3) {
                if (createKey3(temp).equals(key)) {
                    return temp;
                }
            } else {
                System.out.println("[FAILED] Sorry, the keyType you provided is not correct.");
                return null;
            }
        }

        // If not found, we simply print and return null
        System.out.println("[FAILED] Sorry, we could not find any student data associated to this key: " + key + ".");
        return null;
    }

    public int getMaxNumOfEntries() {
        int maxNumOfEntries = 0;
        for (LinkedList<StudentEntry> studentEntries : hashTable) {
            if (studentEntries.size() > maxNumOfEntries) {
                maxNumOfEntries = studentEntries.size();
            }
        }

        return maxNumOfEntries;
    }

    public int getNumberOfCollisions() {
        int numOfCollisions = 0;

        for (LinkedList<StudentEntry> studentEntries : hashTable) {
            if (studentEntries.size() > 1) {
                numOfCollisions += studentEntries.size() - 1;
            }
        }

        return numOfCollisions;
    }

    public int getNumberOfOccupiedBuckets() {
        int numOfOccupiedBuckets = 0;

        for (LinkedList<StudentEntry> studentEntries : hashTable) {
            if (studentEntries.size() > 0) {
                numOfOccupiedBuckets++;
            }
        }

        return numOfOccupiedBuckets;
    }

    public void rehash(int keyType, int hashType) {
        // We copy our current hashTable into a temporary hashTable
        LinkedList<StudentEntry>[] temp = hashTable;
        // Now we reset our current hashTable and double its size
        hashTable = new LinkedList[initialCapacity * 2];

        initialCapacity *= 2;

        // Initialize each of the bucket in our hashTable
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<>();
        }

        size = 0;

        // Now we add the entries again by the help of the temporary hashTable we had created in the beginning
        for (LinkedList<StudentEntry> studentEntries : temp) {
            for (StudentEntry studentEntry : studentEntries) {
                addEntry(studentEntry, keyType, hashType);
            }
        }

        capacityIncrement++;
    }

    public void print(int keyType) {
        LinkedList<String>[] keys = new LinkedList[hashTable.length];

        for (int i = 0; i < keys.length; i++) {
            keys[i] = new LinkedList<>();
        }

        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i].size() == 1) {
                if (keyType == 1) {
                    keys[i].add(createKey(hashTable[i].get(0)));
                } else if (keyType == 2) {
                    keys[i].add(String.valueOf(createKey2(hashTable[i].get(0))));
                } else {
                    keys[i].add(createKey3(hashTable[i].get(0)));
                }
            } else if (hashTable[i].size() > 1) {
                for (int j = 0; j < hashTable[i].size(); j++) {
                    if (keyType == 1) {
                        keys[i].add(createKey(hashTable[i].get(j)));
                    } else if (keyType == 2) {
                        keys[i].add(String.valueOf(createKey2(hashTable[i].get(j))));
                    } else {
                        keys[i].add(createKey3(hashTable[i].get(j)));
                    }
                }
            } else {
                keys[i].add("N/A.");
            }
        }

        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i].size() == 1) {
                System.out.println("[Student #" + (i + 1) + "] \t\t" + hashTable[i].get(0).firstName + " " +
                        hashTable[i].get(0).lastName + ", \t\t" + hashTable[i].get(0).birthYear + " \t--\t " + keys[i].get(0) + ".");
            } else if (hashTable[i].size() > 1) {
                for (int j = 0; j < hashTable[i].size(); j++) {
                    System.out.println("[Student #" + (i + 1) + " - " + (j + 1) + "] \t" + hashTable[i].get(j).firstName + " " +
                            hashTable[i].get(j).lastName + ", \t\t" + hashTable[i].get(j).birthYear + " \t--\t " + keys[i].get(j) + ".");
                }
            } else {
                System.out.println("[Student #" + (i + 1) + "] \t\t" + "Empty Bucket, \t\tN/A \t--\t N/A.");
            }
        }
    }

    public void printStats() {
        System.out.println("[INFO] The total number of collisions were: " + getNumberOfCollisions() + ".");
        System.out.println("[INFO] The total number of times the tables capacity was increased: " + capacityIncrement + ".");
        System.out.println("[INFO] The total number of free buckets: " + (hashTable.length - getNumberOfOccupiedBuckets()) + ".");
        System.out.println("[INFO] The total number of occupied buckets: " + getNumberOfOccupiedBuckets() + ".");
        System.out.println("[INFO] The highest number of entries are: " + getMaxNumOfEntries() + ".");
    }
}

class StudentEntry {
    String firstName;
    String lastName;
    String major;
    int birthYear;
    ContactInfo personalInfo;
    public StudentEntry(String firstNameIn, String lastNameIn, String majorIn, int birthYearIn, ContactInfo
            contactInfoIn)
    {
        firstName = firstNameIn;
        lastName = lastNameIn;
        major = majorIn;
        birthYear = birthYearIn;
        personalInfo = contactInfoIn;
    }

    public void print() {
        System.out.println("[DETAILS] " + firstName + " " + lastName + ", " + birthYear + ", " + major + ", " + personalInfo.phoneNumber + ", " + personalInfo.email + ".");
    }
}

class ContactInfo {
    int phoneNumber;
    String email;
    public ContactInfo(int phoneNumberIn, String emailIn)
    {
        phoneNumber = phoneNumberIn;
        email = emailIn;
    }
}
