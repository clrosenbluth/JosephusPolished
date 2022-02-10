package JosephusFunctional;

import java.util.Random;

/**
 * A class to make a "Josephus" style execution game.
 *
 * This system was, according to the Josephus histories,
 * used by Jewish soldiers at Masada to commit mass suicide.
 * The soldiers form a ring and choose a leader and a number n.
 * The soldiers then count, starting from the leader, killing
 * the nth soldier on each round. This continues until there is
 * one survivor.
 *
 * @author chanarosenbluth
 */
public class Josephus
{
    private final GCLL<Soldier> list;
    private final int numSoldiers;
    private final int numKill;

    private static class Soldier
    {
        private final int number;
        private final int age;
        private final String name;

        public Soldier(int n)
        {
            number = n;
            // I admit this could lead to some pretty funny numbers - but if it's being made up by Josephus, I don't see
            // why it has to be realistic :)
            age = 20 + n;

            Random r = new Random();
            String[] names = {"Liam", "Noah", "Oliver", "Elijah", "William", "James", "Benjamin", "Lucas", "Henry", "Alexander", "Mason", "Michael", "Ethan", "Daniel", "Jacob", "Logan", "Jackson", "Levi", "Sebastian", "Mateo", "Jack", "Owen", "Theodore", "Aiden", "Samuel", "Joseph", "John", "David", "Wyatt", "Matthew", "Luke", "Asher", "Carter", "Julian", "Grayson", "Leo", "Jayden", "Gabriel", "Isaac", "Lincoln", "Anthony", "Hudson", "Dylan", "Ezra", "Thomas", "Charles", "Christophe", "Jaxon", "Maverick", "Josiah", "Isaiah", "Andrew", "Elias", "Joshua", "Nathan", "Caleb", "Ryan", "Adrian", "Miles", "Eli", "Nolan", "Christian", "Aaron", "Cameron", "Ezekiel", "Colton", "Luca", "Landon", "Hunter", "Jonathan", "Santiago ", "Axel", "Easton", "Cooper", "Jeremiah", "Angel", "Roman", "Connor", "Jameson", "Robert", "Greyson", "Jordan", "Ian", "Carson", "Jaxson", "Leonardo", "Nicholas", "Dominic", "Austin", "Everett", "Brook", "Xavier", "Kai", "Jose", "Parker", "Adam", "Jace", "Wesley", "Kayden", "Silas "};
            name = names[r.nextInt(100)];
        }

        public int getAge()
        {
            return age;
        }

        public int getNumber()
        {
            return number;
        }

        public String getName()
        {
            return name;
        }

        public String toString()
        {
            return name +
                    ", age: " +
                    age;
        }
    }

    public Josephus(int numSoldiers, int numKill)
    {
        this.list = new GCLL<>();
        this.numSoldiers = numSoldiers;
        this.numKill = numKill;
    }

    public Soldier execute()
    {
        list.clear();
        generateSoldiers();
        return killSoldiers();
    }

    private void generateSoldiers()
    {
        for (int i = numSoldiers; i >= 1; --i)
        {
            list.addFirst(new Soldier(i));
        }
    }

    private Soldier killSoldiers()
    {
        while(list.size() > 1)
        {
            list.advance(numKill);
            Soldier toBeKilled = list.getFirst();
            list.remove(toBeKilled);
        }
        return list.getFirst();
    }
}

