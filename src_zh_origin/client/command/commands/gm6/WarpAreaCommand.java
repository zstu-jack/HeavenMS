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
   @Author: MedicOP - Add warparea command
*/
package client.command.commands.gm2;

import client.MapleCharacter;
import client.MapleClient;
import client.command.Command;
import server.maps.MapleMap;

import java.awt.*;
import java.util.Collection;

public class WarpAreaCommand extends Command {
    {
        setDescription("");
    }

    @Override
    public void execute(MapleClient c, String[] params) {
        MapleCharacter player = c.getPlayer();
        if (params.length < 1) {
            player.yellowMessage("使用法法: !传送城市 <地图id>");
            return;
        }

        try {
            MapleMap target = c.getChannelServer().getMapFactory().getMap(Integer.parseInt(params[0]));
            if (target == null) {
                player.yellowMessage("地图id" + params[0] + "无效.");
                return;
            }

            Point pos = player.getPosition();

            Collection<MapleCharacter> characters = player.getMap().getAllPlayers();
            
            for (MapleCharacter victim : characters) {
                if (victim.getPosition().distanceSq(pos) <= 50000) {
                    victim.saveLocationOnWarp();
                    victim.changeMap(target, target.getRandomPlayerSpawnpoint());
                }
            }
        } catch (Exception ex) {
            player.yellowMessage("地图id" + params[0] + "无效.");
        }
    }
}
