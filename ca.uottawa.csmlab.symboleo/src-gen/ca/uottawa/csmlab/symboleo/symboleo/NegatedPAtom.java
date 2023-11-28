/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Negated PAtom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.NegatedPAtom#getNegated <em>Negated</em>}</li>
 * </ul>
 *
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getNegatedPAtom()
 * @model
 * @generated
 */
public interface NegatedPAtom extends Proposition
{
  /**
   * Returns the value of the '<em><b>Negated</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Negated</em>' containment reference.
   * @see #setNegated(Proposition)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getNegatedPAtom_Negated()
   * @model containment="true"
   * @generated
   */
  Proposition getNegated();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.NegatedPAtom#getNegated <em>Negated</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Negated</em>' containment reference.
   * @see #getNegated()
   * @generated
   */
  void setNegated(Proposition value);

} // NegatedPAtom