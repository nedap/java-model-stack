package org.openehr.aom.constraintmodel.primitive;

import org.apache.commons.lang.NotImplementedException;
import org.openehr.aom.constraintmodel.ArchetypeConstraint;
import org.openehr.aom.constraintmodel.CPrimitiveObject;
import org.openehr.basetypes.structures.Interval;
import org.openehr.basetypes.time.Time;

/**
 * Constraint on instances of Boolean. Both attributes cannot be set to False,
 * since this would mean that the Boolean value being constrained cannot be
 * True or False.
 *
 * Created by cnanjo on 5/20/16.
 */
public class CBoolean extends CPrimitiveObject<Boolean> {

    /**
     * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
     *
     * @param value
     * @return
     */
    @Override
    public Boolean validValue(Boolean value) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Generate a prototype value from this constraint object.
     *
     * @return
     */
    @Override
    public Boolean prototypeValue() {
        return true;
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts,
     * are narrower or the same as other. Typically used during validation of
     * specialized archetype nodes.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean cConformsTo(ArchetypeConstraint other) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * True if constraints represented by this node contain no further
     * redefinitions with respect to the node other, with the exception
     * of node_id redefinition in C_OBJECT nodes. Typically used to test
     * if an inherited node locally contains any constraints.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean cCongruentTo(ArchetypeConstraint other) {
        throw new NotImplementedException();//TODO Need to implement
    }

    /**
     * Returns true if node is a leaf node (has no children).
     *
     * @return
     */
    @Override
    public Boolean isLeaf() {
        return true;
    }

    /**
     * Generate name of native type that is constrained by this C_XXX type. For most types, it is the C_XXX
     * typename without the 'C_', i.e. XXX. E.g. C_INTEGER → Integer. For the date/time types the mapping
     * is different.
     *
     * @return
     */
    @Override
    public String constrainedTypeName() {
        return "Boolean";
    }
}
