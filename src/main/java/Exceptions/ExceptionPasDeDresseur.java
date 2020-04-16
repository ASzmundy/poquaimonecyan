package Exceptions;

import Statics.Liste_Combats;

public class ExceptionPasDeDresseur extends Exception{
    public ExceptionPasDeDresseur(){
        Liste_Combats.combatTermine();
    }
}
