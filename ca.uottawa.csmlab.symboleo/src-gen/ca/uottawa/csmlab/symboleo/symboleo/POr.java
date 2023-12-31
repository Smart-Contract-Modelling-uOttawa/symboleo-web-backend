/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>POr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.POr#getLeft <em>Left</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.POr#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPOr()
 * @model
 * @generated
 */
public interface POr extends Proposition
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Proposition)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPOr_Left()
   * @model containment="true"
   * @generated
   */
  Proposition getLeft();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.POr#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Proposition value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Proposition)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPOr_Right()
   * @model containment="true"
   * @generated
   */
  Proposition getRight();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.POr#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Proposition value);

} // POr
