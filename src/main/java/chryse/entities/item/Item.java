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

package chryse.entities.item;

import java.util.LinkedHashMap;

import chryse.Querifiable;

public class Item extends Querifiable {

	public int id;
	public String name;
	public String desc;
	public int lv;
	public int reqLevel;
	public int price;
	public int hungry;
	public int life;
	public int slotMax;
	public int time;

	public Item(int id) {
		this.id = id;
	}

	@Override
	public String getTableName() {
		return "items";
	}

	@Override
	public LinkedHashMap<String, Object> getQueryParameters(int relationshipKey) {
		LinkedHashMap<String, Object> parameters = new LinkedHashMap<String, Object>();
		parameters.put("itemId", id);
		parameters.put("name", name);
		parameters.put("description", desc);
		parameters.put("lv", lv);
		parameters.put("reqLevel", reqLevel);
		parameters.put("price", price);
		parameters.put("hungry", hungry);
		parameters.put("life", life);
		parameters.put("slotMax", slotMax);
		parameters.put("time", time);
		return parameters;
	}
}
