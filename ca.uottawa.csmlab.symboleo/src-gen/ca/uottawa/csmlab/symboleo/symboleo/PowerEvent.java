/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.PowerEvent#getEventName <em>Event Name</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.PowerEvent#getPowerVariable <em>Power Variable</em>}</li>
 * </ul>
 *
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPowerEvent()
 * @model
 * @generated
 */
public interface PowerEvent extends Event
{
  /**
   * Returns the value of the '<em><b>Event Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event Name</em>' attribute.
   * @see #setEventName(String)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPowerEvent_EventName()
   * @model
   * @generated
   */
  String getEventName();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.PowerEvent#getEventName <em>Event Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event Name</em>' attribute.
   * @see #getEventName()
   * @generated
   */
  void setEventName(String value);

  /**
   * Returns the value of the '<em><b>Power Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Power Variable</em>' reference.
   * @see #setPowerVariable(Power)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPowerEvent_PowerVariable()
   * @model
   * @generated
   */
  Power getPowerVariable();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.PowerEvent#getPowerVariable <em>Power Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Power Variable</em>' reference.
   * @see #getPowerVariable()
   * @generated
   */
  void setPowerVariable(Power value);

} // PowerEvent
