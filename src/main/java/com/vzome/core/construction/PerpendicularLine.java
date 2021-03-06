

package com.vzome.core.construction;

import com.vzome.core.algebra.AlgebraicVector;


/**
 * @author Scott Vorthmann
 */
public class PerpendicularLine extends Line
{
    private Line mLine1, mLine2;
    private Point mPoint;

    /**
     * @param step
     * @param start
     * @param end
     */
    public PerpendicularLine( Line l1, Line l2, Point p )
    {
        super( l1 .field );
        mLine1 = l1;
        mLine2 = l2;
        mPoint = p;
        mapParamsToState();
    }
    
    /**
     * returns true if something changed.
     * @return
     */
    @Override
    protected final boolean mapParamsToState()
    {
        if ( mLine1 .isImpossible() || mLine2 .isImpossible() || mPoint .isImpossible() )
            return setStateVariables( null, null, true );
        AlgebraicVector norm1 = mLine1 .getDirection();
        AlgebraicVector norm2 = mLine2 .getDirection();
        AlgebraicVector cross = norm1 .cross( norm2 );
        return setStateVariables( mPoint .getLocation(), cross, cross .isOrigin() );
    }
}
