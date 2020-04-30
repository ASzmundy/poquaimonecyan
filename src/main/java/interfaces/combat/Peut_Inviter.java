package interfaces.combat;

import implems.combat.Combat;
import implems.humains.Humain;
import exceptions.humains.ExceptionAmiNonTrouve;
import exceptions.combat.ExceptionCombatNonTrouve;

public interface Peut_Inviter{
    void inviterAmi(Humain ami, Combat combat)throws ExceptionAmiNonTrouve,ExceptionCombatNonTrouve;
}
