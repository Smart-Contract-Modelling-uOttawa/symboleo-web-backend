/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;

import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PAtom Date Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.PAtomDateLiteral#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPAtomDateLiteral()
 * @model
 * @generated
 */
public interface PAtomDateLiteral extends Proposition
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(Date)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPAtomDateLiteral_Value()
   * @model
   * @generated
   */
  Date getValue();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.PAtomDateLiteral#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(Date value);

} // PAtomDateLiteral
