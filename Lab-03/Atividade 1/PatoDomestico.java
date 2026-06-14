public class PatoDomestico implements Pato {
    @Override
    public void voar() {
        System.out.println("Pato Doméstico voando baixinho...");
    }

    @Override
    public void grasnar() {
        System.out.println("Pato Doméstico grasnando: Quack! Quack! Quack!");
    }
}