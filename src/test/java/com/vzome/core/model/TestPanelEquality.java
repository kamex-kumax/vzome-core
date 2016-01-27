
//(c) Copyright 2008, Scott Vorthmann.  All rights reserved.

package com.vzome.core.model;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.vzome.core.algebra.AlgebraicField;
import com.vzome.core.algebra.AlgebraicNumber;
import com.vzome.core.algebra.AlgebraicVector;
import com.vzome.core.algebra.PentagonField;

public class TestPanelEquality extends TestCase
{

    public void testEqualsObject()
    {
        AlgebraicField field = new PentagonField();
        AlgebraicNumber w = field .createRational( new int[]{ 0,1 } );
        AlgebraicNumber x = field .createRational( new int[]{ 1,1 } );
        AlgebraicNumber y = field .createRational( new int[]{ 2,1 } );
        AlgebraicNumber z = field .createRational( new int[]{ 3,1 } );
        AlgebraicVector a = new AlgebraicVector(w, x, y);
        AlgebraicVector b = new AlgebraicVector(z, w, x);
        AlgebraicVector c = new AlgebraicVector(y, z, w);
        AlgebraicVector d = new AlgebraicVector(x, y, z);
        
		ArrayList<AlgebraicVector> list = new ArrayList<>();
        list .add( a );
        list .add( b );
        list .add( c );
        list .add( d );
        Panel p0 = new Panel( list );
		assertFalse(p0 .equals( null ) );
		
        list = new ArrayList<>();
        list .add( d );
        list .add( a );
        list .add( b );
        list .add( c );
        Panel p1 = new Panel( list );
        assertEquals( p0, p1 );
        assertEquals( p0.hashCode(), p1.hashCode() );
		
        list = new ArrayList<>();
        list .add( d );
        list .add( c );
        list .add( b );
        list .add( a );
        Panel p2 = new Panel( list );
        assertTrue( p0 .equals( p2 ) );
        assertTrue( p0.hashCode() == p2.hashCode() );
		
        list = new ArrayList<>();
        list .add( d );
        list .add( b );
        list .add( a );
		// fewer elements in list this time shouldn't be equal
        Panel p3 = new Panel( list );
        assertFalse(p0 .equals( p3 ) );
		// hashCode() is not required to match unless equals() returns true
    }

}
