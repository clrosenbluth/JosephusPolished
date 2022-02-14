package JosephusOOP;

public class Soldier
{
    private String name;
    private int age;
    private int initialPosition;
    private Soldier neighbor;

    public Soldier (String name, int age, int initialPosition)
    {
        this.name = name;
        this.age = age;
        this.initialPosition = initialPosition;
    }

    public Soldier (int initialPosition)
    {
        this.initialPosition = initialPosition;
    }

    public void setNeighbor (Soldier neighbor)
    {
        this.neighbor = neighbor;
    }

    public Soldier execute (int remainingCount)
    {
        while (this.neighbor.neighbor != null)
        {
            if (remainingCount > 1)
            {
                return this.neighbor.execute(remainingCount - 1);
            }
            else
            {
                // remaining count is 1 - kill neighbor
                Soldier killed = this.neighbor;
                this.neighbor = killed.neighbor;
            }
        }

        return this;
    }
}
