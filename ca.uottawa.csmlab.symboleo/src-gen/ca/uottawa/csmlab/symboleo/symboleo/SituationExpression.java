/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Situation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.SituationExpression#getSituation <em>Situation</em>}</li>
 * </ul>
 *
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getSituationExpression()
 * @model
 * @generated
 */
public interface SituationExpression extends IntervalExpression
{
  /**
   * Returns the value of the '<em><b>Situation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Situation</em>' containment reference.
   * @see #setSituation(Situation)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getSituationExpression_Situation()
   * @model containment="true"
   * @generated
   */
  Situation getSituation();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.SituationExpression#getSituation <em>Situation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Situation</em>' containment reference.
   * @see #getSituation()
   * @generated
   */
  void setSituation(Situation value);

} // SituationExpression
