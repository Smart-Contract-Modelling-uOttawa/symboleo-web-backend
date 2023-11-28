/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Point Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.PointFunction#getName <em>Name</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.PointFunction#getArg <em>Arg</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.PointFunction#getValue <em>Value</em>}</li>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.PointFunction#getTimeUnit <em>Time Unit</em>}</li>
 * </ul>
 *
 * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPointFunction()
 * @model
 * @generated
 */
public interface PointFunction extends PointExpression
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPointFunction_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.PointFunction#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Arg</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arg</em>' containment reference.
   * @see #setArg(PointExpression)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPointFunction_Arg()
   * @model containment="true"
   * @generated
   */
  PointExpression getArg();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.PointFunction#getArg <em>Arg</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Arg</em>' containment reference.
   * @see #getArg()
   * @generated
   */
  void setArg(PointExpression value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Timevalue)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPointFunction_Value()
   * @model containment="true"
   * @generated
   */
  Timevalue getValue();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.PointFunction#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Timevalue value);

  /**
   * Returns the value of the '<em><b>Time Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time Unit</em>' attribute.
   * @see #setTimeUnit(String)
   * @see ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage#getPointFunction_TimeUnit()
   * @model
   * @generated
   */
  String getTimeUnit();

  /**
   * Sets the value of the '{@link ca.uottawa.csmlab.symboleo.symboleo.PointFunction#getTimeUnit <em>Time Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time Unit</em>' attribute.
   * @see #getTimeUnit()
   * @generated
   */
  void setTimeUnit(String value);

} // PointFunction