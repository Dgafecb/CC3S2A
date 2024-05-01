public class FootballTeam implements Comparable<FootballTeam>{
    private int gamesWon;
    public FootballTeam(int gamesWon) {
        if(gamesWon<0){
            throw new IllegalArgumentException(
                    "Not possible to have less than 0 games won"
            );
        }
        this.gamesWon = gamesWon;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    @Override
    public int compareTo(FootballTeam footballTeam) {
        //Caso que el equipo tenga mas juegos ganados
        if (gamesWon>footballTeam.getGamesWon()){
            return 1;
        }
        //Caso que el equipo tenga menos juegos ganados
        else if(gamesWon< footballTeam.getGamesWon()){
            return -1;
        }
        //Caso que tengan la misma cantidad de juegos ganados
        return 0;
    }
}
