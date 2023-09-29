import java.util.Scanner;
public class Main {
    public static void start() {
        System.out.println("Would you like to be female or male? Press 1 for female, 0 for male.");

        int choice = checkUserChoice();
        if (choice == 0) {
            System.out.println("okay too bad you're still playing a female character.");
        }
        else if (choice == 1) {
            System.out.println("Great!");
        }
        else{
            System.out.println("Clearly you can't read instructions but ok.");
        }

        System.out.println("\nYou are Beatrice Beaumont, a 33 year old housewife living in the suburbs of Valentine, Texas.");
        System.out.println("\nYour husband is a neglectful misogynistic 68 year old retired banker. You spend your days serving him tea and listening to him talk about trade deals.\n You hate him.");
        System.out.println("\nOh, and he's also been cheating on you with your step-sister for 7 years, but if you call him out he will divorce you and you will be broke and homeless.");
        System.out.println("\nYour goal of the game is to get rich and get rid of your husband. You will do whatever it takes.");
        System.out.println("\nBut don't die.");
    }

    public static int checkUserChoice() {
        System.out.println("Press 1 to do it, 0 to do nothing.");
        Scanner newScanner = new Scanner(System.in);
        int choice = -1;

        while(choice < 0 || choice >1){
            try{
                choice = Integer.parseInt(newScanner.nextLine());
                if (choice !=0 && choice !=1){
                    System.out.println("Please enter 0 or 1, can you read.");
                }
            }
            catch (Exception e){
                System.out.println("Please enter either 0 or 1, can you read.");
            }
        }
        return choice;
    }

    public static void jailFail(){
        System.out.println("You spend the rest of your days frustrated and alone, rotting away in jail.");
    }

    public static void sadFail(){
        System.out.println("Enter your name.");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        System.out.println("Congratulations, " + name + "." + " You have once again allowed the patriarchy to crush you dreams. Better luck next time.");
    }
    public static void success(){
        System.out.println("Enter your name.");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        System.out.println("Congrats, " + name + ", you have won. Your husband is dead and you have gained all of his money.");
    }
    public static void killBill() {
        System.out.println("Your husband is now dead. Do you call the police?");
        if (checkUserChoice()==1){
            System.out.println("The police have arrived. You are pretending to be a sopping wet mess and it manages to fool the cops.");
            success();
        }
        else{
            System.out.println("People eventually deduce that it's you who killed your husband.");
            jailFail();
        }
    }

    public static void betrayHugo(){
        System.out.println("When the cops come, you blame it on Hugo.\n His mouth is agape and he is arrested and sent to jail, no questions asked.");
        System.out.println("During your last encounter, you whisper to him \"Chew on that you wuss.\"");
        System.out.println("You have crushed all the condescending men who have gotten in your way in life");
        success();
    }

    public static int goHugo(){
        System.out.println("You and Hugo have many secret rendezvous from now on. He starts to be really infatuated with you. \n In reality, he's kind of shallow and only talks about himself, and he's a lowkey misogynist, but you think he will be useful for the future.");
        System.out.println("Turns out you are correct. At the perfect moment, you ask Hugo what to do about your filthy husband. He brings up the idea of murder. You happily go with it.");
        System.out.println("While you and your husband are out shopping, a mysterious figure pushes a shopping cart into him and it hits him right in his spot of weakness.");
        System.out.println("You have the chance to pin the murder on Hugo (remember, he treats you like a dog). Do you do it?");
        if (checkUserChoice()==1){
            betrayHugo();
            return 0;
        }
        killBill();
        return 0;
    }

    public static int meetGuy(){
        System.out.println("\nYour husband is out. You hear a knock at the door. Do you open the door?");
        if (checkUserChoice()==1) {
            System.out.println("The door opens. It's a mysterious man who looks like a blend of Charles Leclerc and Leonardo Dicaprio (in Titanic).\n He says: \"Hello Madam. I'm looking for a Mr. Fletcher. May I ask if he's home?\" Do you let him in?");
            if (checkUserChoice()==1){
                System.out.println("You respond, \"I'm Mrs. Beaumont. My husband isn't home, but he will be back in an hour or two.\"");
                System.out.println("\nThe man introduces himself as Hugo Fletcher. He's an influential businessman who controls the biggest supermarket chain in the United States.");
                System.out.println("\nHe wants to pitch to you a new business model. If you say yes, there's no turning back.");
                if (checkUserChoice()==1){
                    return 1;
                }
                System.out.println("You push him out of your life. You go back to being miserable and bored for ever and ever");
                sadFail();
                return 0;

            }
            else{
                System.out.println("You were supposed to be interested in talking to him but if you hate adventure that's fine too. You spend the rest of your days miserable and alone.");
                sadFail();
                return 0;
            }
        }
        else {
            System.out.println("When your husband comes home, an inexplicable thirst for blood takes over.");
            System.out.println("In a fit of rage, you suddenly get an epiphany: just crush his 7 rolex watches and he will spiral into madness, you can blame his death on mental illness.\n Do you choose to kill?");
            if (checkUserChoice() == 1) {
                killBill();
                return 0;
            } else {
                System.out.println("You spend the rest of your days miserable and alone, never again with a viable plan to kill him.");
                sadFail();
                return 0;
            }


        }

    }

    public static void mustDo(){
        System.out.println("Before you play the game you have to do this so I can fulfill the lab requirements.");
        System.out.println("Please enter your age.");
        Scanner ageScanner = new Scanner(System.in);
        int age = ageScanner.nextInt();
        if (age<1){
            System.out.println("Stop lying.\nWhatever start playing the game.\n");
            return;
        }
        System.out.println("The singles digit of your age is " + age%10);
        System.out.println("Your age times two is " + age*2);
        System.out.println("One year ago you were " + (age-1) + " years old.");
        if (age/2 < 5){
            System.out.println("Warning: you probably are too young to play this game but I don't really care so do what you want.\n");
        }
    }

    public static void main(String[] args) {
        mustDo();
        start();
        if (meetGuy() == 0){
            return;
        }
        else{
            goHugo();
        }




    }
}
