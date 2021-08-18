/*
    This file is part of the HeavenMS MapleStory Server, commands OdinMS-based
    Copyleft (L) 2016 - 2019 RonanLana

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

/*
   @Author: Arthur L - Refactored command content into modules
*/
package client.command.commands.gm2;

import client.MapleJob;
import client.command.Command;
import client.MapleClient;
import client.MapleCharacter;

public class JobCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient c, String[] params) {
        MapleCharacter player = c.getPlayer();
        if (params.length == 1) {
            int jobid = Integer.parseInt(params[0]);
            if (jobid < 0 || jobid >= 2200) {
                player.message("Jobid " + jobid + " is not available.");
                return;
            }

            player.changeJob(MapleJob.getById(jobid));
            player.equipChanged();
        } else if (params.length == 2) {
            MapleCharacter victim = c.getWorldServer().getPlayerStorage().getCharacterByName(params[0]);

            if (victim != null) {
                int jobid = Integer.parseInt(params[1]);
                if (jobid < 0 || jobid >= 2200) {
                    player.message("Jobid " + jobid + " is not available.");
                    return;
                }

                victim.changeJob(MapleJob.getById(jobid));
                player.equipChanged();
            } else {
                player.message("Player '" + params[0] + "' could not be found.");
            }
        } else {
            player.message("Syntax: !job <job id> <opt: IGN of another person>");
            player.message("WARRIOR(100)  | FIGHTER(110)   CRUSADER(111), HERO(112)\n");
            player.message("PAGE(120), WHITEKNIGHT(121), PALADIN(122)\n");
            player.message("SPEARMAN(130), DRAGONKNIGHT(131), DARKKNIGHT(132)\n\n");

            player.message("MAGICIAN(200) | FP_WIZARD(210) FP_MAGE(211),  FP_ARCHMAGE(212)\n");
            player.message("IL_WIZARD(220), IL_MAGE(221), IL_ARCHMAGE(222)\n");
            player.message("CLERIC(230), PRIEST(231), BISHOP(232)\n\n");

            player.message("BOWMAN(300)   | HUNTER(310)    RANGER(311),   BOWMASTER(312)\n");
            player.message("CROSSBOWMAN(320), SNIPER(321), MARKSMAN(322)\n");

            player.message("THIEF(400)    | ASSASSIN(410)  HERMIT(411),   NIGHTLORD(412)\n");
            player.message("BANDIT(420), CHIEFBANDIT(421), SHADOWER(422)\n\n");

            player.message("PIRATE(500)   | BRAWLER(510)   MARAUDER(511), BUCCANEER(512)\n");
            player.message("GUNSLINGER(520), OUTLAW(521), CORSAIR(522)\n\n");

            player.message("MAPLELEAF_BRIGADIER(800) | GM(900), SUPERGM(910)\n");
            player.message("NOBLESSE(1000)\n");
            player.message("DAWNWARRIOR1(1100), DAWNWARRIOR2(1110), DAWNWARRIOR3(1111), DAWNWARRIOR4(1112)\n");
            player.message("BLAZEWIZARD1(1200), BLAZEWIZARD2(1210), BLAZEWIZARD3(1211), BLAZEWIZARD4(1212)\n");
            player.message("WINDARCHER1(1300), WINDARCHER2(1310), WINDARCHER3(1311), WINDARCHER4(1312)\n");
            player.message("NIGHTWALKER1(1400), NIGHTWALKER2(1410), NIGHTWALKER3(1411), NIGHTWALKER4(1412)\n");
            player.message("THUNDERBREAKER1(1500), THUNDERBREAKER2(1510), THUNDERBREAKER3(1511), THUNDERBREAKER4(1512)\n");

            player.message("LEGEND(2000), EVAN(2001)\n");
            player.message("ARAN1(2100), ARAN2(2110), ARAN3(2111), ARAN4(2112)\n");
            
            player.message("EVAN1(2200), EVAN2(2210), EVAN3(2211), EVAN4(2212), EVAN5(2213), EVAN6(2214)\n");
            player.message("EVAN7(2215), EVAN8(2216), EVAN9(2217), EVAN10(2218)\n");
        
    
        
        }
    }
}
