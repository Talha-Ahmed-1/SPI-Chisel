// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Design implementation internals
// See VBlackBoxAdder.h for the primary calling header

#include "VBlackBoxAdder.h"    // For This
#include "VBlackBoxAdder__Syms.h"

//--------------------
// STATIC VARIABLES


//--------------------

VL_CTOR_IMP(VBlackBoxAdder) {
    VBlackBoxAdder__Syms* __restrict vlSymsp = __VlSymsp = new VBlackBoxAdder__Syms(this, name());
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Reset internal values
    
    // Reset structure values
    _ctor_var_reset();
}

void VBlackBoxAdder::__Vconfigure(VBlackBoxAdder__Syms* vlSymsp, bool first) {
    if (0 && first) {}  // Prevent unused
    this->__VlSymsp = vlSymsp;
}

VBlackBoxAdder::~VBlackBoxAdder() {
    delete __VlSymsp; __VlSymsp=NULL;
}

//--------------------


void VBlackBoxAdder::eval() {
    VBlackBoxAdder__Syms* __restrict vlSymsp = this->__VlSymsp; // Setup global symbol table
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Initialize
    if (VL_UNLIKELY(!vlSymsp->__Vm_didInit)) _eval_initial_loop(vlSymsp);
    // Evaluate till stable
    VL_DEBUG_IF(VL_PRINTF("\n----TOP Evaluate VBlackBoxAdder::eval\n"); );
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

void VBlackBoxAdder::_eval_initial_loop(VBlackBoxAdder__Syms* __restrict vlSymsp) {
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

VL_INLINE_OPT void VBlackBoxAdder::_combo__TOP__1(VBlackBoxAdder__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_PRINTF("    VBlackBoxAdder::_combo__TOP__1\n"); );
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    // ALWAYS at BlackBoxAdder.v:7
    vlTOPp->out = (VL_ULL(0x3ffffffff) & (vlTOPp->in1 
					  + vlTOPp->in2));
}

void VBlackBoxAdder::_eval(VBlackBoxAdder__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_PRINTF("    VBlackBoxAdder::_eval\n"); );
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    vlTOPp->_combo__TOP__1(vlSymsp);
}

void VBlackBoxAdder::_eval_initial(VBlackBoxAdder__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_PRINTF("    VBlackBoxAdder::_eval_initial\n"); );
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
}

void VBlackBoxAdder::final() {
    VL_DEBUG_IF(VL_PRINTF("    VBlackBoxAdder::final\n"); );
    // Variables
    VBlackBoxAdder__Syms* __restrict vlSymsp = this->__VlSymsp;
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
}

void VBlackBoxAdder::_eval_settle(VBlackBoxAdder__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_PRINTF("    VBlackBoxAdder::_eval_settle\n"); );
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    vlTOPp->_combo__TOP__1(vlSymsp);
}

VL_INLINE_OPT QData VBlackBoxAdder::_change_request(VBlackBoxAdder__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_PRINTF("    VBlackBoxAdder::_change_request\n"); );
    VBlackBoxAdder* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    // Change detection
    QData __req = false;  // Logically a bool
    return __req;
}

void VBlackBoxAdder::_ctor_var_reset() {
    VL_DEBUG_IF(VL_PRINTF("    VBlackBoxAdder::_ctor_var_reset\n"); );
    // Body
    in1 = VL_RAND_RESET_Q(33);
    in2 = VL_RAND_RESET_Q(33);
    out = VL_RAND_RESET_Q(34);
    __Vm_traceActivity = VL_RAND_RESET_I(32);
}

void VBlackBoxAdder::_configure_coverage(VBlackBoxAdder__Syms* __restrict vlSymsp, bool first) {
    VL_DEBUG_IF(VL_PRINTF("    VBlackBoxAdder::_configure_coverage\n"); );
    // Body
    if (0 && vlSymsp && first) {} // Prevent unused
}
