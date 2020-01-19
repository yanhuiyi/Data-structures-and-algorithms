package designpattern.decorator;

public class Program {
    public static void main(String[] args) {
        Component component, componentSB, componentBB;
        component = new Window();
        componentSB = new ScrollBarDecorator(component);
//        componentSB.display();

        componentBB = new BlackBorderDecorator(componentSB);
        componentBB.display();
    }
}
