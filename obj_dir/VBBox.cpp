// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Design implementation internals
// See VBBox.h for the primary calling header

#include "VBBox.h"             // For This
#include "VBBox__Syms.h"

//--------------------
// STATIC VARIABLES


//--------------------

VL_CTOR_IMP(VBBox) {
    VBBox__Syms* __restrict vlSymsp = __VlSymsp = new VBBox__Syms(this, name());
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Reset internal values
    
    // Reset structure values
    _ctor_var_reset();
}

void VBBox::__Vconfigure(VBBox__Syms* vlSymsp, bool first) {
    if (0 && first) {}  // Prevent unused
    this->__VlSymsp = vlSymsp;
}

VBBox::~VBBox() {
    delete __VlSymsp; __VlSymsp=NULL;
}

//--------------------


void VBBox::eval() {
    VBBox__Syms* __restrict vlSymsp = this->__VlSymsp; // Setup global symbol table
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Initialize
    if (VL_UNLIKELY(!vlSymsp->__Vm_didInit)) _eval_initial_loop(vlSymsp);
    // Evaluate till stable
    VL_DEBUG_IF(VL_PRINTF("\n----TOP Evaluate VBBox::eval\n"); );
    int __VclockLoop = 0;
    QData __Vchange=1;
    while (VL_LIKELY(__Vchange)) {
	VL_DEBUG_IF(VL_PRINTF(" Clock loop\n"););
	vlSymsp->__Vm_activity = true;
	_eval(vlSymsp);
	__Vchange = _change_request(vlSymsp);
	if (++__VclockLoop > 100) vl_fatal(__FILE__,__LINE__,__FILE__,"Verilated model didn't converge");
    }
}

void VBBox::_eval_initial_loop(VBBox__Syms* __restrict vlSymsp) {
    vlSymsp->__Vm_didInit = true;
    _eval_initial(vlSymsp);
    vlSymsp->__Vm_activity = true;
    int __VclockLoop = 0;
    QData __Vchange=1;
    while (VL_LIKELY(__Vchange)) {
	_eval_settle(vlSymsp);
	_eval(vlSymsp);
	__Vchange = _change_request(vlSymsp);
	if (++__VclockLoop > 100) vl_fatal(__FILE__,__LINE__,__FILE__,"Verilated model didn't DC converge");
    }
}

//--------------------
// Internal Methods

VL_INLINE_OPT void VBBox::_combo__TOP__1(VBBox__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_PRINTF("    VBBox::_combo__TOP__1\n"); );
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    vlTOPp->io_out = (vlTOPp->io_in1 + vlTOPp->io_in2);
}

void VBBox::_eval(VBBox__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_PRINTF("    VBBox::_eval\n"); );
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    vlTOPp->_combo__TOP__1(vlSymsp);
}

void VBBox::_eval_initial(VBBox__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_PRINTF("    VBBox::_eval_initial\n"); );
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
}

void VBBox::final() {
    VL_DEBUG_IF(VL_PRINTF("    VBBox::final\n"); );
    // Variables
    VBBox__Syms* __restrict vlSymsp = this->__VlSymsp;
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
}

void VBBox::_eval_settle(VBBox__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_PRINTF("    VBBox::_eval_settle\n"); );
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    vlTOPp->_combo__TOP__1(vlSymsp);
}

VL_INLINE_OPT QData VBBox::_change_request(VBBox__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_PRINTF("    VBBox::_change_request\n"); );
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    // Change detection
    QData __req = false;  // Logically a bool
    return __req;
}

void VBBox::_ctor_var_reset() {
    VL_DEBUG_IF(VL_PRINTF("    VBBox::_ctor_var_reset\n"); );
    // Body
    clock = VL_RAND_RESET_I(1);
    reset = VL_RAND_RESET_I(1);
    io_in1 = VL_RAND_RESET_I(32);
    io_in2 = VL_RAND_RESET_I(32);
    io_out = VL_RAND_RESET_I(32);
    __Vm_traceActivity = VL_RAND_RESET_I(32);
}

void VBBox::_configure_coverage(VBBox__Syms* __restrict vlSymsp, bool first) {
    VL_DEBUG_IF(VL_PRINTF("    VBBox::_configure_coverage\n"); );
    // Body
    if (0 && vlSymsp && first) {} // Prevent unused
}
