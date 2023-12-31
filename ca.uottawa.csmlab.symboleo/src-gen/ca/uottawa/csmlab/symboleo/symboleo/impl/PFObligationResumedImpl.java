/**
 * generated by Xtext 2.31.0
 */
package ca.uottawa.csmlab.symboleo.symboleo.impl;

import ca.uottawa.csmlab.symboleo.symboleo.Obligation;
import ca.uottawa.csmlab.symboleo.symboleo.PFObligationResumed;
import ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PF Obligation Resumed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ca.uottawa.csmlab.symboleo.symboleo.impl.PFObligationResumedImpl#getNorm <em>Norm</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PFObligationResumedImpl extends PowerFunctionImpl implements PFObligationResumed
{
  /**
   * The cached value of the '{@link #getNorm() <em>Norm</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNorm()
   * @generated
   * @ordered
   */
  protected Obligation norm;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PFObligationResumedImpl()
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
    return SymboleoPackage.Literals.PF_OBLIGATION_RESUMED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Obligation getNorm()
  {
    if (norm != null && norm.eIsProxy())
    {
      InternalEObject oldNorm = (InternalEObject)norm;
      norm = (Obligation)eResolveProxy(oldNorm);
      if (norm != oldNorm)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SymboleoPackage.PF_OBLIGATION_RESUMED__NORM, oldNorm, norm));
      }
    }
    return norm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Obligation basicGetNorm()
  {
    return norm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setNorm(Obligation newNorm)
  {
    Obligation oldNorm = norm;
    norm = newNorm;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SymboleoPackage.PF_OBLIGATION_RESUMED__NORM, oldNorm, norm));
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
      case SymboleoPackage.PF_OBLIGATION_RESUMED__NORM:
        if (resolve) return getNorm();
        return basicGetNorm();
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
      case SymboleoPackage.PF_OBLIGATION_RESUMED__NORM:
        setNorm((Obligation)newValue);
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
      case SymboleoPackage.PF_OBLIGATION_RESUMED__NORM:
        setNorm((Obligation)null);
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
      case SymboleoPackage.PF_OBLIGATION_RESUMED__NORM:
        return norm != null;
    }
    return super.eIsSet(featureID);
  }

} //PFObligationResumedImpl
