package com.felix.common.object;

import java.io.*;

/**
 * Class that contains methods for working with {@link Object}.
 */
public class Objects {

    /**
     * Returns true if has any object null.
     * @param objects varargs of objects.
     * @return true if any object is null.
     */
    public static boolean hasNull(Object... objects) {
        if (objects == null || objects.length == 0)
            return true;

        for (Object object : objects) {
            if (object == null)
                return true;
        }

        return false;
    }

    /**
     * Return a new instance of object with equals values.
     * @param obj object to clone.
     * @param <T> generic type of object.
     * @return a cloned object.
     */
    public static <T extends Serializable> T clone(T obj) {
        return deserialize(serialize(obj));
    }

    /**
     * Returns a serialized object.
     * @param obj object to serialize.
     * @param <T> generic type of object.
     * @return serialized object.
     */
    public static <T extends Serializable> byte[] serialize(T obj) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(obj);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a object deserialized.
     * @param bytes object to deserialize.
     * @param <T> generic type of object.
     * @return deserialized object.
     */
    public static <T extends Serializable> T deserialize(byte[] bytes) {
        try (ByteArrayInputStream bos = new ByteArrayInputStream(bytes); ObjectInputStream in = new ObjectInputStream(bos)) {
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
