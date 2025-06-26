public interface UserInputRetriever <T> {
    abstract T produceOutput(int selection) throws IllegalArgumentException;
}
