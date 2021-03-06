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

package chryse;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Querifiable {

	public abstract LinkedHashMap<String, Object> getQueryParameters(int relationshipKey);

	public abstract String getTableName();

	public void addTableStructure(StringBuilder query, int relationshipKey) {
		HashMap<String, Object> parameters = getQueryParameters(relationshipKey);

		query.append("INSERT INTO " + getTableName() + " (");
		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			query.append(entry.getKey() + ", ");
		}
		query.setLength(query.length() - 2);
		query.append(") VALUES\r\n");
	}

	public void addTableData(StringBuilder query, int relationshipKey) {
		HashMap<String, Object> parameters = getQueryParameters(relationshipKey);

		query.append("(");

		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			if (entry.getValue() == null) {
				query.append("NULL, ");
				continue;
			}
			if (entry.getValue() instanceof Integer) {
				query.append(entry.getValue().toString() + ", ");
			} else if (entry.getValue() instanceof String) {
				String string = (String) entry.getValue();
				if (string.contains("'") && string.contains("\"")) {
					string = string.replace("'", "''");
					query.append("'" + string + "', ");
				} else if (string.contains("'")) {
					query.append("\"" + string + "\", ");
				} else {
					query.append("'" + string + "', ");
				}
			}
		}
		query.setLength(query.length() - 2);
		query.append("),\r\n");
	}
}
