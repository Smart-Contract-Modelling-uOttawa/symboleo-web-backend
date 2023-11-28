/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Expression Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionParameter#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getAtomicExpressionParameter()
 * @model
 * @generated
 */
public interface AtomicExpressionParameter extends Expression
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Ref)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getAtomicExpressionParameter_Value()
   * @model containment="true"
   * @generated
   */
  Ref getValue();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionParameter#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Ref value);

} // AtomicExpressionParameter
