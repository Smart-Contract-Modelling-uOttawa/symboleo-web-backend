/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate Function SHappens Before Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionSHappensBeforeEvent#getEvent1 <em>Event1</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionSHappensBeforeEvent#getEvent2 <em>Event2</em>}</li>
 * </ul>
 *
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPredicateFunctionSHappensBeforeEvent()
 * @model
 * @generated
 */
public interface PredicateFunctionSHappensBeforeEvent extends PredicateFunction
{
  /**
   * Returns the value of the '<em><b>Event1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event1</em>' containment reference.
   * @see #setEvent1(Event)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPredicateFunctionSHappensBeforeEvent_Event1()
   * @model containment="true"
   * @generated
   */
  Event getEvent1();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionSHappensBeforeEvent#getEvent1 <em>Event1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event1</em>' containment reference.
   * @see #getEvent1()
   * @generated
   */
  void setEvent1(Event value);

  /**
   * Returns the value of the '<em><b>Event2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event2</em>' containment reference.
   * @see #setEvent2(Event)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPredicateFunctionSHappensBeforeEvent_Event2()
   * @model containment="true"
   * @generated
   */
  Event getEvent2();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionSHappensBeforeEvent#getEvent2 <em>Event2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event2</em>' containment reference.
   * @see #getEvent2()
   * @generated
   */
  void setEvent2(Event value);

} // PredicateFunctionSHappensBeforeEvent