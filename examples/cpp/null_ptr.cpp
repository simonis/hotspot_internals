struct NullCheck {
  long x, y, z;
  long l0001;
};

void getField(NullCheck* n1, NullCheck* n2, NullCheck* n3, NullCheck* n4) {
  long tmp = n1->l0001;
  n1->l0001 = n2->l0001;
  n2->l0001 = n3->l0001;
  n3->l0001 = n4->l0001;
  n4->l0001 = tmp;
}

int main(int argc, char** argv) {
  NullCheck* n = (NullCheck*)0;
  getField(n, n, n, n);
}
