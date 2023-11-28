/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo.impl;

import ca.uottawa.csmlab.symboleo.symboleo.Power;
import ca.uottawa.csmlab.symboleo.symboleo.PowerState;
import ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.impl.PowerStateImpl#getPowerVariable <em>Power Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PowerStateImpl extends SituationImpl implements PowerState
{
  /**
   * The cached value of the '{@link #getPowerVariable() <em>Power Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPowerVariable()
   * @generated
   * @ordered
   */
  protected Power powerVariable;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PowerStateImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SymboleoPackage.Literals.POWER_STATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Power getPowerVariable()
  {
    if (powerVariable != null && powerVariable.eIsProxy())
    {
      InternalEObject oldPowerVariable = (InternalEObject)powerVariable;
      powerVariable = (Power)eResolveProxy(oldPowerVariable);
      if (powerVariable != oldPowerVariable)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SymboleoPackage.POWER_STATE__POWER_VARIABLE, oldPowerVariable, powerVariable));
      }
    }
    return powerVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Power basicGetPowerVariable()
  {
    return powerVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPowerVariable(Power newPowerVariable)
  {
    Power oldPowerVariable = powerVariable;
    powerVariable = newPowerVariable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.POWER_STATE__POWER_VARIABLE, oldPowerVariable, powerVariable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SymboleoPackage.POWER_STATE__POWER_VARIABLE:
        if (resolve) return getPowerVariable();
        return basicGetPowerVariable();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SymboleoPackage.POWER_STATE__POWER_VARIABLE:
        setPowerVariable((Power)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SymboleoPackage.POWER_STATE__POWER_VARIABLE:
        setPowerVariable((Power)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SymboleoPackage.POWER_STATE__POWER_VARIABLE:
        return powerVariable != null;
    }
    return super.eIsSet(featureID);
  }

} //PowerStateImpl