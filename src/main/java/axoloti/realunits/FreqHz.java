/**
 * Copyright (C) 2013, 2014 Johannes Taelman
 * Edited 2023 - 2024 by Ksoloti
 *
 * This file is part of Axoloti.
 *
 * Axoloti is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Axoloti is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Axoloti. If not, see <http://www.gnu.org/licenses/>.
 */
package axoloti.realunits;

import axoloti.datatypes.Value;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.ParseException;

/**
 *
 * @author Johannes Taelman
 */
public class FreqHz implements NativeToReal {

    @Override
    public String ToReal(Value v) {
        double hz = 48000.0 * 0.5 * v.getDouble() / 64.0;
        if (hz > 10000.0) {
            return (String.format("%.1f kHz", hz / 1000));
        }
        if (hz > 1000.0) {
            return (String.format("%.2f kHz", hz / 1000));
        } else if (hz > 100.0) {
            return (String.format("%.1f Hz", hz));
        } else {
            return (String.format("%.2f Hz", hz));
        }
    }

    @Override
    public double FromReal(String s) throws ParseException {
        Pattern pattern = Pattern.compile("(?<num>[\\d\\.\\-\\+]*)\\p{Space}*(?<unit>[kKmM]?)[hH][zZ]?");
        Matcher matcher = pattern.matcher(s);

        if (matcher.matches()) {
            double num, mul = 1.0;

            try {
                num = Float.parseFloat(matcher.group("num"));
            } catch (java.lang.NumberFormatException ex) {
                throw new ParseException("Not FreqHz", 0);
            }

            String units = matcher.group("unit");
            if (units.contains("m") || units.contains("M"))
                mul = 0.001;
            if (units.contains("k") || units.contains("K"))
                mul = 1000;

            double hz = num * mul;
            return (hz * 64.0) / (48000.0 * 0.5);
        }

        throw new ParseException("Not FreqHz", 0);
    }
}
