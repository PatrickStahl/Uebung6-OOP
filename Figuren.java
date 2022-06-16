abstract class Figure
{
    protected float x;
    protected float y;

    Figure()
    {
        this.x = 0;
        this.y = 0;
    }

    Figure(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX() 
    {
        return x;
    }

    public float getY() 
    {
        return y;
    }

    public void print()
    {
        System.out.println("X: " + x + " Y: " + y);
    }
}

interface MobileObject
{
    public void move(float x, float y);
    public void increase(float x);
    public void decreade(float y);
}

class Rectangle extends Figure implements MobileObject
{
    private float width;
    private float height;

    Rectangle()
    {
        super();
        this.width = 0;
        this.height = 0;
    }

    Rectangle(float x, float y, float width, float height)
    {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    public float getHeight() 
    {
        return height;
    }

    public float getWidth() 
    {
        return width;
    }

    @Override
    public void print()
    {
        super.print();
        System.out.println("Höhe: " + height + " Breite: " + width);
    }


    public void move(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void increase(float inc)
    {
        width = width * inc;
        height = height * inc;
    }
    public void decreade(float dec)
    {
        width = width / dec;
        height = height / dec;
    }

    public void relation(Rectangle rectangle)
    {
        if((x==rectangle.x) && (y==rectangle.y) && (width==rectangle.width) && (height==rectangle.height))
        {
            System.out.println("same");
        }

        if((x>=rectangle.x && y>=rectangle.y) && ((((x+width)<=(rectangle.x+rectangle.width)) && ((y+height)< (rectangle.y + rectangle.height))) || (((x+width)<(rectangle.x+rectangle.width)) && ((y+height) <= (rectangle.y + rectangle.height)))))
        {
            System.out.println("contained");
        }

        //rechts, oben, unten, links
        if((((x + width) - rectangle.x) < 0) || ((y- (rectangle.y + rectangle.height)) > 0) || ((rectangle.y - (y+height))>0) || (((rectangle.x + rectangle.width) - x) < 0))
        {
            System.out.println("disjoint");
        }


        //ich weiß noch nicht ob die alligned methoden stimmen, könnt die gerne mal ausprobieren und mir bescheid sagen

        //rechts
        if((x+width == rectangle.x) && ((y < rectangle.y + rectangle.height) || (y+height > rectangle.y)))
        {
            System.out.println("alligned");
        }

        //drüber
        if(((y+height==rectangle.y) && ((rectangle.x + rectangle.width > x) || (x+ width > rectangle.x))))
        {
            System.out.println("alligned");
        }

        //drunter
        if((y == rectangle.y + rectangle.height) && ((x < rectangle.x + rectangle.width) || (x + width > rectangle.x)))
        {
            System.out.println("alligned");
        }

        //links
        if((rectangle.x + rectangle.width == x) && ((y + height > rectangle.y) || (rectangle.y + rectangle.height > y)))
        {
            System.out.println("alligned");
        }

    }   
}

public class Figuren
{
    public static void main(String[] args) 
    {
        Rectangle rectangle1 = new Rectangle(3, 4, 5, 6);
        //rectangle1.increase(3);
        rectangle1.print();    
        Rectangle rectangle2 = new Rectangle(8, 4, 12, 5);
        rectangle2.print();
        rectangle1.relation(rectangle2);
    }
}