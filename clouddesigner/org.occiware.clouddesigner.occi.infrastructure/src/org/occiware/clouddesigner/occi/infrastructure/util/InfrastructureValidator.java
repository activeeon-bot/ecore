/**
 */
package org.occiware.clouddesigner.occi.infrastructure.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.occiware.clouddesigner.OCCI.util.OCCIValidator;

import org.occiware.clouddesigner.occi.infrastructure.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.occiware.clouddesigner.occi.infrastructure.InfrastructurePackage
 * @generated
 */
public class InfrastructureValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final InfrastructureValidator INSTANCE = new InfrastructureValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.occiware.clouddesigner.occi.infrastructure";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCCIValidator occiValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfrastructureValidator() {
		super();
		occiValidator = OCCIValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return InfrastructurePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case InfrastructurePackage.NETWORK:
				return validateNetwork((Network)value, diagnostics, context);
			case InfrastructurePackage.COMPUTE:
				return validateCompute((Compute)value, diagnostics, context);
			case InfrastructurePackage.STORAGE:
				return validateStorage((Storage)value, diagnostics, context);
			case InfrastructurePackage.STORAGELINK:
				return validateStoragelink((Storagelink)value, diagnostics, context);
			case InfrastructurePackage.NETWORKINTERFACE:
				return validateNetworkinterface((Networkinterface)value, diagnostics, context);
			case InfrastructurePackage.SUSPEND_METHOD:
				return validateSuspendMethod((SuspendMethod)value, diagnostics, context);
			case InfrastructurePackage.NETWORK_STATUS:
				return validateNetworkStatus((NetworkStatus)value, diagnostics, context);
			case InfrastructurePackage.COMPUTE_STATUS:
				return validateComputeStatus((ComputeStatus)value, diagnostics, context);
			case InfrastructurePackage.NETWORK_INTERFACE_STATUS:
				return validateNetworkInterfaceStatus((NetworkInterfaceStatus)value, diagnostics, context);
			case InfrastructurePackage.ARCHITECTURE:
				return validateArchitecture((Architecture)value, diagnostics, context);
			case InfrastructurePackage.STOP_METHOD:
				return validateStopMethod((StopMethod)value, diagnostics, context);
			case InfrastructurePackage.RESTART_METHOD:
				return validateRestartMethod((RestartMethod)value, diagnostics, context);
			case InfrastructurePackage.ALLOCATION:
				return validateAllocation((Allocation)value, diagnostics, context);
			case InfrastructurePackage.STORAGE_STATUS:
				return validateStorageStatus((StorageStatus)value, diagnostics, context);
			case InfrastructurePackage.STORAGE_LINK_STATUS:
				return validateStorageLinkStatus((StorageLinkStatus)value, diagnostics, context);
			case InfrastructurePackage.INTEGER4095:
				return validateInteger4095((Integer)value, diagnostics, context);
			case InfrastructurePackage.TOKEN:
				return validateToken((String)value, diagnostics, context);
			case InfrastructurePackage.IP_ADDRESS:
				return validateIpAddress((String)value, diagnostics, context);
			case InfrastructurePackage.POSITIVE_INTEGER:
				return validatePositiveInteger((Integer)value, diagnostics, context);
			case InfrastructurePackage.GHZ:
				return validateGHz((Float)value, diagnostics, context);
			case InfrastructurePackage.GI_B:
				return validateGiB((Float)value, diagnostics, context);
			case InfrastructurePackage.IP_ADDRESS_RANGE:
				return validateIpAddressRange((String)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNetwork(Network network, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(network, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(network, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(network, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(network, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(network, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(network, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(network, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(network, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(network, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_IdUnique(network, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_AttributesNameUnique(network, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_KindCompatibleWithOneAppliesOfEachMixin(network, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateResource_ResourceKindIsInParent(network, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompute(Compute compute, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(compute, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(compute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(compute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(compute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(compute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(compute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(compute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(compute, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(compute, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_IdUnique(compute, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_AttributesNameUnique(compute, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_KindCompatibleWithOneAppliesOfEachMixin(compute, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateResource_ResourceKindIsInParent(compute, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStorage(Storage storage, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(storage, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(storage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(storage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(storage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(storage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(storage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(storage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(storage, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(storage, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_IdUnique(storage, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_AttributesNameUnique(storage, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_KindCompatibleWithOneAppliesOfEachMixin(storage, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateResource_ResourceKindIsInParent(storage, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStoragelink(Storagelink storagelink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(storagelink, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(storagelink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(storagelink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(storagelink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(storagelink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(storagelink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(storagelink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(storagelink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(storagelink, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_IdUnique(storagelink, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_AttributesNameUnique(storagelink, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_KindCompatibleWithOneAppliesOfEachMixin(storagelink, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateLink_LinkKindIsInParent(storagelink, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNetworkinterface(Networkinterface networkinterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(networkinterface, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(networkinterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(networkinterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(networkinterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(networkinterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(networkinterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(networkinterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(networkinterface, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(networkinterface, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_IdUnique(networkinterface, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_AttributesNameUnique(networkinterface, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateEntity_KindCompatibleWithOneAppliesOfEachMixin(networkinterface, diagnostics, context);
		if (result || diagnostics != null) result &= occiValidator.validateLink_LinkKindIsInParent(networkinterface, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSuspendMethod(SuspendMethod suspendMethod, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNetworkStatus(NetworkStatus networkStatus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComputeStatus(ComputeStatus computeStatus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNetworkInterfaceStatus(NetworkInterfaceStatus networkInterfaceStatus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArchitecture(Architecture architecture, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStopMethod(StopMethod stopMethod, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRestartMethod(RestartMethod restartMethod, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllocation(Allocation allocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStorageStatus(StorageStatus storageStatus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStorageLinkStatus(StorageLinkStatus storageLinkStatus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteger4095(int integer4095, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateInteger4095_Min(integer4095, diagnostics, context);
		if (result || diagnostics != null) result &= validateInteger4095_Max(integer4095, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateInteger4095_Min
	 */
	public static final int INTEGER4095__MIN__VALUE = 0;

	/**
	 * Validates the Min constraint of '<em>Integer4095</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteger4095_Min(int integer4095, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = integer4095 >= INTEGER4095__MIN__VALUE;
		if (!result && diagnostics != null)
			reportMinViolation(InfrastructurePackage.Literals.INTEGER4095, integer4095, INTEGER4095__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateInteger4095_Max
	 */
	public static final int INTEGER4095__MAX__VALUE = 4095;

	/**
	 * Validates the Max constraint of '<em>Integer4095</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInteger4095_Max(int integer4095, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = integer4095 <= INTEGER4095__MAX__VALUE;
		if (!result && diagnostics != null)
			reportMaxViolation(InfrastructurePackage.Literals.INTEGER4095, integer4095, INTEGER4095__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateToken(String token, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpAddress(String ipAddress, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePositiveInteger(int positiveInteger, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGHz(float gHz, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGiB(float giB, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpAddressRange(String ipAddressRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //InfrastructureValidator
