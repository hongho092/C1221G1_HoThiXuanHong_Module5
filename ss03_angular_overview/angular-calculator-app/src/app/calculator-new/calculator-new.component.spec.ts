import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculatorNewComponent } from './calculator-new.component';

describe('CalculatorNewComponent', () => {
  let component: CalculatorNewComponent;
  let fixture: ComponentFixture<CalculatorNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CalculatorNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CalculatorNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
