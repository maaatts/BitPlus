/* Copyright (C) 2015 maaatts

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>. */

/* Copyright (C) 2015 maaatts

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package me.themallard.bitmmo.impl.transformer;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodNode;

import me.themallard.bitmmo.api.analysis.util.pattern.Pattern;
import me.themallard.bitmmo.api.analysis.util.pattern.PatternBuilder;
import me.themallard.bitmmo.api.analysis.util.pattern.element.LdcElement;
import me.themallard.bitmmo.api.transformer.Transformer;
import me.themallard.bitmmo.api.util.Filter;
import me.themallard.bitmmo.impl.analysis.LaserWeapon;

// just a test, dont ban me plz.
public class LaserWeaponGodTransformer extends Transformer {
	public LaserWeaponGodTransformer() {
		super("LaserWeaponGod");

		addFilter(new Filter<ClassNode>() {
			@Override
			public boolean accept(ClassNode cn) {
				return getRefactoredName(cn.name) == new LaserWeapon().getName();
			}
		});
	}

	@Override
	public void run(ClassNode cn) {
		Pattern p = new PatternBuilder().add(new LdcElement(new LdcInsnNode("TakeSelfDamage"))).build();

		for (MethodNode mn : cn.methods) {
			int offset = p.getOffset(mn.instructions);

			if (offset != -1) {
				mn.instructions.insertBefore(mn.instructions.get(offset), new InsnNode(Opcodes.RETURN));
			}
		}
	}
}