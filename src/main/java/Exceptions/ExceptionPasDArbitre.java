package Exceptions;

import Statics.Liste_Combats;

public class ExceptionPasDArbitre extends Exception{
    public ExceptionPasDArbitre(){
        Liste_Combats.combatTermine();
    }
}
