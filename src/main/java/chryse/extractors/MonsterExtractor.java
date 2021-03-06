/*
 	This file is part of Lachelein: MapleStory Web Database
 	Copyright (C) 2017  Alan Morel <alan.morel@nyu.edu>
	Copyright (C) 2017  Brenterino <therealspookster@gmail.com>

	Permission is hereby granted, free of charge, to any person obtaining
	a copy of this software and associated documentation files (the
	"Software"), to deal in the Software without restriction, including
	without limitation the rights to use, copy, modify, merge, publish,
	distribute, sublicense, and/or sell copies of the Software, and to
	permit persons to whom the Software is furnished to do so, subject
	to the following conditions:

	The above copyright notice and this permission notice shall be included
	in all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
	OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
	THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR
	OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
	ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
	OTHER DEALINGS IN THE SOFTWARE.
*/

package chryse.extractors;

import chryse.Database;
import chryse.Extractor;
import chryse.Target;
import chryse.entities.monster.Monster;
import wz.WzObject;
import wz.WzProperty;
import wz.common.WzDataTool;

public class MonsterExtractor extends Extractor {

	public MonsterExtractor(Target target) {
		super(target, "Mob");
	}

	@Override
	public void parse(WzObject<?, ?> parent, String path) {

		WzObject<?, ?> info = parent.getChild("info");

		int id = getId(path);
		Monster monster = Database.getMonster(id);

		monster.acc = WzDataTool.getInteger(info, "acc", -1);
		monster.boss = WzDataTool.getInteger(info, "boss", 0);
		monster.bodyAttack = WzDataTool.getInteger(info, "bodyAttack", -1);
		monster.eva = WzDataTool.getInteger(info, "eva", -1);
		monster.exp = WzDataTool.getInteger(info, "exp", -1);
		monster.level = WzDataTool.getInteger(info, "level", -1);
		monster.MADamage = WzDataTool.getInteger(info, "MADamage", -1);
		monster.maxHP = WzDataTool.getInteger(info, "maxHP", -1);
		monster.maxMP = WzDataTool.getInteger(info, "maxMP", -1);
		monster.MDDamage = WzDataTool.getInteger(info, "MDDamage", -1);
		monster.PADamage = WzDataTool.getInteger(info, "PADamage", -1);
		monster.PDDamage = WzDataTool.getInteger(info, "PDDamage", -1);
		monster.pushed = WzDataTool.getInteger(info, "pushed", -1);
		monster.speed = WzDataTool.getInteger(info, "speed", -1);
		monster.undead = WzDataTool.getInteger(info, "undead", -1);

		dumpImage(parent, path);
	}

	private void dumpImage(WzObject<?, ?> parent, String path) {
		WzProperty<?> stand = (WzProperty<?>) parent.getChildByPath("stand/0");
		if (stand != null) {
			extractImage(stand, path);
		}
	}
}
