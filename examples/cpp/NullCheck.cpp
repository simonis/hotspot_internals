struct NullCheck {
  long l0001;
};

__attribute__ ((noinline))
void swapFields(NullCheck* n1, NullCheck* n2) {
  long tmp = n1->l0001;
  n1->l0001 = n2->l0001;
  n2->l0001 = tmp;
}

int main(int argc, char** argv) {
  NullCheck* n = (NullCheck*)0;
  swapFields(n, n);
}
