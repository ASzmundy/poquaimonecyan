package Interfaces;

import Classes.Combat;
import Classes.Humain;
import Exceptions.ExceptionAmiNonTrouve;
import Exceptions.ExceptionCombatNonTrouve;

public interface Peut_Inviter{
    public void inviterAmi(Humain ami, Combat combat)throws ExceptionAmiNonTrouve,ExceptionCombatNonTrouve;
}
